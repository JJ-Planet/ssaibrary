import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  value: 1,
};

export const counterSlice = createSlice({
  name: "counter",
  initialState,
  reducers: {
    first: (state) => {
      // Redux Toolkit allows us to write "mutating" logic in reducers. It
      // doesn't actually mutate the state because it uses the Immer library,
      // which detects changes to a "draft state" and produces a brand new
      // immutable state based off those changes
      state.value = 1;
    //   console.log(1)
    },
    second: (state) => {
      state.value = 2;
    },
    third: (state) => {
      state.value = 3;
    },
  },
});

// Action creators are generated for each case reducer function
export const { first, second, third } = counterSlice.actions;

export default counterSlice.reducer;
