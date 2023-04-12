import React from "react";

function Floor1() {
  return (
    <>
      <div className="RoomLocation">
        <div className="RoomSeperator"></div>
        <span className="LocationLabel">대전 캠퍼스 1층</span>
      </div>
      <div className="Room301Div">
        <span className="Room301Num">101</span>
        <span className="Room301Status">예약 가능</span>
        <div className="Room301Obj RoomUsable"></div>
      </div>
      <div className="Room302Div">
        <span className="Room302Num">102</span>
        <span className="Room302Status">사용 중</span>
        <div className="Room302Obj RoomFull"></div>
      </div>
      <div className="Room303Div">
        <span className="Room303Num">103</span>
        <span className="Room303Status">
          <span id="color">16</span>/24
        </span>
        <div className="Room303Obj RoomUsable"></div>
      </div>
      <div className="Room304Div">
        <span className="Room304Num">104</span>
        <span className="Room304Status">23/24</span>
        <div className="Room304Obj RoomUsable"></div>
      </div>
      <div className="Room305Div">
        <span className="Room305Num">105</span>
        <span className="Room305Status">17/30</span>
        <div className="Room305Obj RoomUsable"></div>
      </div>
    </>
  );
}

export default Floor1;
