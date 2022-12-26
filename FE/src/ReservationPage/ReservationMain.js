import React from "react";
import "./ReservationMain.css";
function Body() {
  return (
    <>
      <div className="Body">
        <div className="ReservationCardDiv">
          <div className="DateLabelDiv">
            <span className="DateText">2022. 12. 22 (목)</span>
          </div>
          <div className="ReservationDiv">
            <div className="ReservationDescDiv">
              <div className="ReservationDescText">
                <span className="SeatData">303호 07번</span>
                <span className="TimeData">09:00 - 13:00</span>
              </div>
              <div className="ImgBar"></div>
              <div className="QRImg"></div>
            </div>
            <div className="ShareBtnDiv">
              <span className="ShareText">공유 하기</span>
            </div>
            <div className="ResvationCancleBtnDiv">
              <span className="ResvationCancleText">예약 취소</span>
            </div>
          </div>
        </div>
        <div className="ReservationCardDiv2">
          <div className="DateLabelDiv">
            <span className="DateText">2022. 12. 22 (목)</span>
          </div>
          <div className="ReservationDiv">
            <div className="ReservationDescDiv">
              <div className="ReservationDescText">
                <span className="SeatData">303호 07번</span>
                <span className="TimeData">09:00 - 13:00</span>
              </div>
              <div className="ImgBar"></div>
              <div className="QRImg"></div>
            </div>
            <div className="ShareBtnDiv">
              <span className="ShareText">공유 하기</span>
            </div>
            <div className="ResvationCancleBtnDiv">
              <span className="ResvationCancleText">예약 취소</span>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Body;
