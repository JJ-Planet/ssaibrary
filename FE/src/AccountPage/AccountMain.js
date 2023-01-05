import React from "react";
import "./AccountMain.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

function Main() {
  const navigate = useNavigate();
  function logoutAlert() {
    Swal.fire({
      title: "로그아웃 하시려고요??",
      text: "떠나지마요..",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Log out",
    }).then((result) => {
      if (result.isConfirmed) {
        navigate("/login");
        Swal.fire("로그아웃되었습니다.", "다음에 또 봐요!", "success"); 
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
              <div className="accountUpdateIcon1"></div>
            </Link>
          </div>
          <div className="accountLogOutDiv" onClick={logoutAlert}>
            <div className="LogOutTitle">로그아웃</div>
            <div className="accountUpdateIcon2"></div>
          </div>
        </div>
        <div className="accountMainDiv2">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv2Label">예약 확인 및 사용 기록</div>
          <div className="AccountReservationDiv">
            <Link to="/account/reservation">
              <div className="accountUpdateTitle">예약 확인</div>
              <div className="accountUpdateIcon1"></div>
            </Link>
          </div>
          <div className="UsageHistoryDiv">
            <Link to="/history">
              <div className="UsageHistoryTitle">사용 기록</div>
              <div className="accountUpdateIcon2"></div>
            </Link>
          </div>
        </div>
        <div className="accountMainDiv3">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv1Label">일반</div>
          <div className="accountUpdateDiv">
            <Link to="/notice">
              <div className="accountUpdateTitle">공지사항</div>
              <div className="accountUpdateIcon1"></div>
            </Link>
          </div>
          <div className="accountUpdateDiv">
            <Link to="/faq">
              <div className="accountUpdateTitle">FAQ</div>
              <div className="accountUpdateIcon2"></div>
            </Link>
          </div>
          <div className="accountUpdateDiv">
            <div className="accountUpdateTitle">문의하기</div>
            <div className="accountUpdateIcon3"></div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
