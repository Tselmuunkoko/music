import * as React from 'react';
import { AudioRecorder, useAudioRecorder } from 'react-audio-voice-recorder';
import { detect } from '../services/detection';
import { useState } from "react";
import { useDispatch } from 'react-redux'
import { setValue } from '../features/shazamResult';

export default function Audio() {
  const [seconds, setSeconds] = useState("");
  const recorderControls = useAudioRecorder()
  const dispatch = useDispatch()
  const addAudioElement = (blob) => {
    var reader = new FileReader();
    reader.readAsDataURL(blob);
    reader.onloadend = async function () {
      var base64String = reader.result;
      var data = base64String.substr(base64String.indexOf(',') + 1)
      var result = await detect(data);
      dispatch(setValue(result.data))
    }
  };
  const onClickRecord = () => {
    recorderControls.startRecording();
    setSeconds(0)
    console.log('started');
    const interval = setInterval(setSeconds(seconds+1), 1000);
    setTimeout(() => {
      console.log('stopped');
      recorderControls.stopRecording()
      const saveButton = document.getElementsByClassName("audio-recorder-mic")[0]
      saveButton.click();
      clearInterval(interval);
    }, 5000);
  }
  return (
    <div>
      <div class="hidden">
        <AudioRecorder onRecordingComplete={addAudioElement} recorderControls={recorderControls}/>
      </div>
      <button onClick={onClickRecord}>start recording</button>
      {/* <p>{seconds}</p> */}
    </div>
  );
}
