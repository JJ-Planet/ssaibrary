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
      <div className="AccountModifyMain">
        <div className="AccountModifyTitleDiv">
          <span className="AccountModifyMainTitle">정보 수정</span>
          <span className="AccountModifySubTitle">회원님의 정보를 수정하세요!</span>
        </div>
        <div className="AccountModifyProfileDiv">
          <div className="ProfileImage"></div>
          <div className="AccountProfileImgDiv"></div>
        </div>
        <div className="AccountModifyInputs">
          <div className="SignUpIDDiv">
            <span className="SignUpIDLabel">ID</span>
            <form>
              <input
                className="SignUpIDInput AccountModifyReadOnlyInput"
                type="text"
                placeholder="010-1234-5678"
                readOnly
              ></input>
            </form>
          </div>
          <div className="SignUpNameDiv">
            <span className="SignUpNameLabel">Name</span>
            <form>
              <input className="SignUpNameInput" type="text" value={"지환"}></input>
            </form>
          </div>
          <div className="SignUpNickNameDiv">
            <span className="SignUpNickLabel">Nick Name</span>
            <form>
              <input className="SignUpNickInput" type="text" value={"지환"}></input>
            </form>
          </div>
          <div className="SignUpPWDiv">
            {/* <div className="SignUpPWView"></div> */}
            <span className="SignUpPWLabel">Password</span>
            <form>
              <input className="SignUpPWInput" type="password" placeholder="변경할 비밀번호를 입력해 주세요 :)"></input>
            </form>
          </div>
          <div className="SignUpPWChkDiv">
            {/* <div className="SignUpPWHidden"></div> */}
            <span className="SignUpPWChkLabel">Password Check</span>
            <form>
              <input className="SignUpPWChkInput" type="password" placeholder="한번 더 똑같이 적어주세요."></input>
            </form>
          </div>
        </div>
        <div className="AccountModifyBtnsDiv">
          <div className="AcceptBtnDiv" onClick={modifyConfirm}>
            {/* <Link to="/account"> */}
              <span className="AccepBtnText">적용하기</span>
            {/* </Link> */}
            <div className="AcceptBtn"></div>
          </div>
          <div className="CancleBtnDiv">
            <Link to="/account">
              <span className="CancleBtnText">취소</span>
            </Link>
            <div className="CancleBtn"></div>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default AccountModifyPage;
