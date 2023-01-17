import { createSlice } from '@reduxjs/toolkit'

export const shazamSlice = createSlice({
  name: 'shazam',
  initialState: {
    value: {},
  },
  reducers: {
    setValue: (state, obj) => {
        state.value = obj
    }
  },
})

// Action creators are generated for each case reducer function
export const { setValue } = shazamSlice.actions

export default shazamSlice.reducer