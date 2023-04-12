import React from "react";
import "./AccountMain.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

function Main() {
  const navigate = useNavigate();
  function logoutAlert() {
    Swal.fire({
      text: "로그아웃 하시겠습니까?",
      showCancelButton: true,
      confirmButtonColor: "rgba(51, 28, 158, 0.74);",
      cancelButtonColor: "#d33",
      confirmButtonText: "로그아웃",
      cancelButtonText: "　취소　",
      icon: "question",
      width: 300,
      heightAuto: false,
      backdrop: `rgba(0,0,0,0.4)`,
      allowEnterKey: true,
    }).then((result) => {
      if (result.isConfirmed) {
        navigate("/login");
        Swal.fire({
          text: "다음에 또 봐요!",
          icon: "success",
          width: 300,
        });
      }
    });
  }

  return (
    <>
      <div className="accountMain">
        <div className="accountMainDiv1">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv1Label">내 정보</div>
          <div className="accountUpdateDiv">
            <Link to="/account/modify">
              <span className="accountUpdateTitle">정보 수정</span>
              <div>
                <img
                  className="accountUpdateIcon1"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
            </Link>
          </div>
          <div className="accountLogOutDiv" onClick={logoutAlert}>
            <div className="LogOutTitle">로그아웃</div>
            <div>
              <img
                className="accountUpdateIcon2"
                src="assets/images/arrowRight.png"
              ></img>
            </div>
          </div>
        </div>
        <div className="accountMainDiv2">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv2Label">예약 확인 및 사용 기록</div>
          <div className="AccountReservationDiv">
            <Link to="/account/reservation">
              <div className="accountUpdateTitle">예약 확인</div>
              <div>
                <img
                  className="accountUpdateIcon1"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
            </Link>
          </div>
          <div className="UsageHistoryDiv">
            <Link to="/history">
              <div className="UsageHistoryTitle">사용 기록</div>
              <div>
                <img
                  className="accountUpdateIcon2"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
            </Link>
          </div>
        </div>
        <div className="accountMainDiv3">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv1Label">일반</div>
          <div className="accountUpdateDiv">
            <Link to="/notice">
              <div className="accountUpdateTitle">공지사항</div>
              <div>
                <img
                  className="accountUpdateIcon1"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
            </Link>
          </div>
          <div className="accountUpdateDiv">
            <Link to="/faq">
              <div className="accountUpdateTitle">FAQ</div>
              <div>
                <img
                  className="accountUpdateIcon2"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
            </Link>
          </div>
          <div className="accountUpdateDiv">
            <div className="accountUpdateTitle">문의하기</div>
            <div>
                <img
                  className="accountUpdateIcon3"
                  src="assets/images/arrowRight.png"
                ></img>
              </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
