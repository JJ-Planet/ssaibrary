import React, { useEffect, useParams, useState } from "react";

import "./ReservationListMain.css";

// import { Link } from "react-router-dom";

import Floor from "../../components/Floor/Floor";
import FloorListView from "../../components/Floor/FloorListView";

//
function Main() {
  return (
    <div className="ReservationListMain">
      <Floor></Floor>
    </div>
  );
}

export default Main;
