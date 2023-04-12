import React, {useEffect, useParams} from "react";

import "./ReservationListMain.css";

// import { Link } from "react-router-dom";

import Floor1 from "../../components/Floor/Floor1";
import Floor2 from "../../components/Floor/Floor2";

function Main() {
  let isDefault = true;
  // useEffect(()=>{
  //   if(roomId !== 0){
  //       isDefault = false;
  //   }
  // }, [])
  
  if(isDefault){
    
    return (
      <>
        <div className="ReservationListMain">
          <Floor1></Floor1>
        </div>
      </>
    );
  } else{
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
