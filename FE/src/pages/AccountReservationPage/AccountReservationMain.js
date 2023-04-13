import React, { useState } from "react";
import "./AccountReservationMain.css";
import Swal from "sweetalert2";
import QRCode from "qrcode";

// const cancleBtn = document.querySelector(".ResvationCancleBtnDiv1");
// const cancleModal = document.querySelector("#modal");
// cancleBtn.addEventListener("click", () => {
//   cancleModal.style.display = "block";
//   console.log("hi");
// });
function Body() {
  const dummyQRData = "hi I'm DummyData";
  const [QRData, setQRData] = useState("");
  QRCode.toDataURL(dummyQRData).then((data) => setQRData(data));

  const info = "303호 07번";
  const time = "09:00 - 13:00";
  // const img = ''
  function imgClick() {
    Swal.fire({
      title: `${info}`,
      text: `${time}`,
      // imageUrl: `${img}`,
      imageUrl: "https://unsplash.it/400/200",
      imageWidth: 350,
      imageHeight: 350,
      imageAlt: "Custom image",
    });
  }

  function reservationCancle() {
    if (window.confirm("예약을 취소하시겠습니까?")) {
      console.log("성공");
    }
  }

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
              <div onClick={imgClick}>
                <img className="QRImg" src={QRData} />
              </div>
            </div>
            <div className="ShareBtnDiv">
              <span className="ShareText">이미지 저장</span>
            </div>
            <div className="ResvationCancleBtnDiv1">
              <span className="ResvationCancleText" onClick={reservationCancle}>
                예약 취소
              </span>
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
              <div>
                <img className="QRImg" src={QRData} />
              </div>
            </div>
            <div className="ShareBtnDiv">
              <span className="ShareText">이미지 저장</span>
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
