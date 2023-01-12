import base64
import ffmpeg
import os
from flask import Flask, flash, request, redirect, url_for, send_from_directory
from werkzeug.utils import secure_filename

app = Flask(__name__)
UPLOAD_FOLDER = '/Users/odtselmuun/2022_1/sde/audio-converter/uploads'
ALLOWED_EXTENSIONS = {'mp3'}

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

""" Encoded base64 string of byte[] that generated 
    from raw data less than 500KB (3-5 seconds sample
    are good enough for detection). The raw sound
    data must be 44100Hz, 1 channel (Mono), signed
    16 bit PCM little endian. Other types of media
    are NOT supported, such as : mp3, wav, etc… or
    need to be converted to uncompressed raw data."""

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        # check if the post request has the file part
        if 'file' not in request.files:
            flash('No file part')
            return redirect(request.url)
        file = request.files['file']
        # If the user does not select a file, the browser submits an
        # empty file without a filename.
        if file.filename == '':
            flash('No selected file')
            return redirect(request.url)
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
            out, _ = (ffmpeg
                    .input(UPLOAD_FOLDER+'/'+filename)
                    .output("-", format='s16le', acodec='pcm_s16le', ac=1, ar='44100')
                    .overwrite_output()
                    .run(capture_stdout=True))
            result = base64.b64encode(out).decode("utf-8")
            return result
            # return redirect(url_for('download_file', name=filename))
    return '''
    <!doctype html>
    <title>Upload new File</title>
    <h1>Upload new File</h1>
    <form method=post enctype=multipart/form-data>
      <input type=file name=file>
      <input type=submit value=Upload>
    </form>
    '''

@app.route('/uploads/<name>')
def download_file(name):
    return send_from_directory(app.config["UPLOAD_FOLDER"], name)