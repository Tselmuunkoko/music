import { createSlice } from '@reduxjs/toolkit'

export const topSlice = createSlice({
  name: 'top',
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
export const { setValue } = topSlice.actions

export default topSlice.reducer