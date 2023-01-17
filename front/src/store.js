import { configureStore } from '@reduxjs/toolkit'
import counterReducer from './features/counterSlice'
import shazamReducer from './features/shazamResult'

export default configureStore({
  reducer: {
    counter: counterReducer,
    shazam: shazamReducer
  },
})