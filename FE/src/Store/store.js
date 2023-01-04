import { configureStore } from '@reduxjs/toolkit'
import counterReducer from '../Store/counterFloor'

export const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
})