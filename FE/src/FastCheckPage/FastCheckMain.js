import React, { useEffect } from "react";
import "./ReservationListMain.css";
import { useSelector, useDispatch } from "react-redux";

import Floor1 from "./Floor1";
import Floor3 from "./Floor2";
import Floor2 from "./Floor3";
// import  { first, second, third } from "../Store/counterFloor"
function Main() {
  const floor = useSelector((state) => state.counter.value);
  // console.log(floor)
  // console.log("this one")
  const dispatch = useDispatch();

  useEffect(() => {
    console.log(floor + "바뀜");
  }, floor);

  switch (floor) {
    case 0:
      return (
        <>
        <div>${floor}</div>
          <div className="ReservationListMain">
            <Floor3></Floor3>
          </div>
        </>
      );
    case 1:
      return (
        <>
          <div className="ReservationListMain">
            <Floor1></Floor1>
          </div>
        </>
      );
    case 2:
      return (
        <>
          <div className="ReservationListMain">
            <Floor2></Floor2>
          </div>
        </>
      );
  }
}

export default Main;
