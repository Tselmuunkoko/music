var Lame = require('lame');
 
// // create the Encoder instance
// var encoder = new lame.Encoder({
//   // input
//   channels: 2,        // 2 channels (left and right)
//   bitDepth: 16,       // 16-bit samples
//   sampleRate: 44100,  // 44,100 Hz sample rate
 
//   // output
//   bitRate: 16,
//   outSampleRate: 44100,
//   mode: lame.MONO // STEREO (default), JOINTSTEREO, DUALCHANNEL or MONO
// });
 
// // raw PCM data from stdin gets piped into the encoder
// process.stdin.pipe(encoder);
 
// // the generated MP3 file gets piped to stdout
// encoder.pipe(process.stdout);

const encodeBlobToRaw = (audioBlob) => {
    const reader = new FileReader();
    reader.readAsArrayBuffer(audioBlob);
    reader.onloadend = function() {
      const mp3Data = new Uint8Array(reader.result);
      const mp3Decoder = new Lame.Mp3Decoder();
      const samples = mp3Decoder.decodeBuffer(mp3Data);
  
      const rawData = new Float32Array(samples.length);
      for (let i = 0; i < samples.length; i++) {
        rawData[i] = samples[i] / 32768;
      }
  
      const rawFile = new Float32Array(rawData);
      return rawFile
    };
}
export {encodeBlobToRaw}