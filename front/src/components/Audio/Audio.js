import * as React from 'react';
import { AudioRecorder } from 'react-audio-voice-recorder';
import encodeBlobToRaw from '../../utils/audioConverter';

export default function Audio() {
  const addAudioElement = (blob) => {
    encodeBlobToRaw(blob);
    console.log((blob));
    const url = URL.createObjectURL(blob);
    const audio = document.createElement('audio');
    audio.src = url;
    console.log(url);
    audio.controls = true;
    document.body.appendChild(audio);
  };

  return (
    <div>
      <AudioRecorder onRecordingComplete={addAudioElement} />
      <br />
    </div>
  );
}