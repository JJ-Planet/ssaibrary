import React from "react";
import Footer from "../LandingPage/CopyRightFooter";
import "./AccountModifyPage.css";
import "../LoginPage/LoginMain.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

const AccountModifyPage = () => {
  const navigate = useNavigate();
  function modifyConfirm() {
    Swal.fire({
      title: "이대로 적용할까요??",
      text: "비밀번호를 변경하셨다면 한번 더 확인해주세요!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Confirm",
    }).then((result) => {
      if (result.isConfirmed) {
        navigate("/account");
        Swal.fire("수정이 완료되었습니다.", "", "success");
      }
    });
  }
  return (
    <div className="AccountModify">
      <div className="AMMain">
        <div className="AMMainHeader">
          <div className="AMTitleDiv">
            <span className="AMMainTitle">정보 수정</span>
            <span className="AMSubTitle">회원님의 정보를 수정하세요!</span>
          </div>
          <div className="AMProfileDiv">
            <div>
              <img className="AMProfileImage" src = "/assets/images/man.png" />
            </div>
          </div>
        </div>
        <div className="AMMainBody">
          <form>
            <div className="AMIDDiv">
              <span className="AMIDLabel">ID</span>
              <input
                className="AMIDReadOnlyInput"
                type="text"
                placeholder="010-1234-5678"
                readOnly
              ></input>
            </div>
            <div className="AMNameDiv">
              <span className="AMNameLabel">Name</span>
              <input className="AMNameInput" type="text" defaultValue={"홍길동"}></input>
            </div>
            <div className="AMNickNameDiv">
              <span className="AMNickNameLabel">Nick Name</span>
              <input className="AMNickNameInput" type="text" defaultValue={"지환"}></input>
            </div>
            <div className="AMPWDiv">
              {/* <div className="SignUpPWView"></div> */}
              <span className="AMPWLabel">Password</span>
              <input
                className="AMPWInput"
                type="password"
                placeholder="변경할 비밀번호를 입력해 주세요 :)"
              ></input>
            </div>
            <div className="AMPWChkDiv">
              {/* <div className="AMPWHidden"></div> */}
              <span className="AMPWChkLabel">Password Check</span>
              <input
                className="AMPWChkInput"
                type="password"
                placeholder="한번 더 똑같이 적어주세요."
              ></input>
            </div>
          </form>
          <div className="AMBtnsDiv">
            <Link to="/account">
              <div className="AcceptBtnDiv" onClick={modifyConfirm}>
                <span className="AccepBtnText">적용하기</span>
                <div className="AcceptBtn"></div>
              </div>
            </Link>

            <Link to="/account">
              <div className="CancleBtnDiv">
                <span className="CancleBtnText">취소</span>
                <div className="CancleBtn"></div>
              </div>
            </Link>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default AccountModifyPage;
