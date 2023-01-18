import { configureStore } from '@reduxjs/toolkit'
import counterReducer from './features/counterSlice'
import shazamReducer from './features/shazamResult'
import top from './features/top'

export default configureStore({
  reducer: {
    counter: counterReducer,
    shazam: shazamReducer,
    top: top
  },
})