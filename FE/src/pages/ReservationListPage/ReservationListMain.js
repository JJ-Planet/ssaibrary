import React, { useEffect, useParams, useState } from "react";

import "./ReservationListMain.css";

// import { Link } from "react-router-dom";

import Floor from "../../components/Floor/Floor";
import FloorListView from "../../components/Floor/FloorListView";

function Main() {
  // const [displayFlag, setDisplayFlag] = useState(0);
  // const [display, setDisplay] = useState(
  //   <div className="ReservationListMain">
  //     <FloorListView
  //       displayFlag={displayFlag}
  //       setDisplayFlag={setDisplayFlag}
  //     ></FloorListView>
  //   </div>
  // );

  // useEffect(() => {
  //   switch (displayFlag) {
  //     case 0:
  //       setDisplay(
  //         <div className="ReservationListMain">
  //           <FloorListView
  //             displayFlag={displayFlag}
  //             setDisplayFlag={setDisplayFlag}
  //           ></FloorListView>
  //         </div>
  //       );
  //       break;
  //     case 1:
  //       setDisplay(
  //         <div className="ReservationListMain">
  //           <Floor1></Floor1>
  //         </div>
  //       );
  //       break;
  //   }
  // }, [displayFlag]);

  return (
    <div className="ReservationListMain">
      <Floor></Floor>
    </div>
  );
}

export default Main;
