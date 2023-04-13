import React from "react";
import "./FastCheckMain";
import { useSelector } from "react-redux";

import Floor from "../../components/Floor/Floor";

// import Floor1 from "../../components/Floor/Floor1";
// import Floor2 from "../../components/Floor/Floor2";
// import Floor3 from "../../components/Floor/Floor3";

function Main() {
  const floor = useSelector((state) => state.counter.value);

  switch (floor) {
    case 1:
      return (
        <>
          <div className="ReservationListMain">
            <Floor></Floor>
          </div>
        </>
      );
    case 2:
      return (
        <>
          <div className="ReservationListMain">
            <Floor></Floor>
          </div>
        </>
      );
    case 3:
      return (
        <>
          <div className="ReservationListMain">
            <Floor></Floor>
          </div>
        </>
      );
    default:
      return (
        <>
          <div className="ReservationListMain">
            <Floor></Floor>
          </div>
        </>
      );
  }
}

export default Main;
