import React from "react";
import "./AccountReservationMain.css";
// const cancleBtn = document.querySelector(".ResvationCancleBtnDiv1");
// const cancleModal = document.querySelector("#modal");
// cancleBtn.addEventListener("click", () => {
//   cancleModal.style.display = "block";
//   console.log("hi");
// });
function Body() {
  return (
    <>
      <div className="Body">
        {/* <div className="modal" id="modal">
          <div className="modal_body">
            <div className="m_head">
              <div className="modal_title">예약을 취소하시겠습니까?</div>
            </div>
            <div className="m_body">
              <div className="modal_btn cancle" id="close_btn">
                CANCLE
              </div>
              <div className="modal_btn save" id="save_btn">
                SAVE
              </div>
            </div>
          </div>
        </div> */}
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
            <div className="ResvationCancleBtnDiv1">
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
