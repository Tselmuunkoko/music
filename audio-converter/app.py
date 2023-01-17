import base64
import ffmpeg
import os
from flask import Flask, flash, request, redirect, url_for, send_from_directory
from werkzeug.utils import secure_filename
import json
import tempfile
from pathlib import Path
import uuid
from shazam import detect as shazam, search
from youtube import yt as yt_search

app = Flask(__name__)

""" Encoded base64 string of byte[] that generated 
    from raw data less than 500KB (3-5 seconds sample
    are good enough for detection). The raw sound
    data must be 44100Hz, 1 channel (Mono), signed
    16 bit PCM little endian. Other types of media
    are NOT supported, such as : mp3, wav, etc… or
    need to be converted to uncompressed raw data."""

@app.route('/', methods=['POST'])
def detect():
    with tempfile.TemporaryDirectory() as tmpdirname:
        temp_dir = Path(tmpdirname)
        if request.method == 'POST':
            filename = uuid.uuid4().hex
            wav_file = open(temp_dir / f'{filename}.webm', "wb")
            audio = json.loads(request.json['data'][0])
            decode_string =  base64.b64decode(audio['audio'])
            wav_file.write(decode_string) 
            wav_file.close()
            out, _ = (ffmpeg
                    .input(temp_dir / f'{filename}.webm')
                    .output("-", format='s16le', acodec='pcm_s16le', ac=1, ar='44100')
                    .overwrite_output()
                    .run(capture_stdout=True))
            result = base64.b64encode(out).decode("utf-8")
            os.remove(temp_dir / f'{filename}.webm')
            yt_response = []
            response = shazam(result)
            if 'track' in response.text:
                # print(json.loads(json.dumps(response.text)))
                print(response.json()['track'])
                yt_response = yt_search(response.json()['track']['title'])
            data = {
                "yt": yt_response,
                "shazam": response.json()
            }
            return data
        return "something went wrong"

@app.route('/yt', methods=['GET'])
def yt():
    return yt_search(request.data)
