import React from "react";
import "./SignUpMain.css";
// import { Link } from "react-router-dom";
function Main() {
  return (
    <>
      <div className="SignUpMain">
        <div className="SignUpInputsDiv">
          <div className="SignUpIDDiv">
            <span className="SignUpIDLabel">ID</span>
            <form>
              <input className="SignUpIDInput" type="text" placeholder="ex) 010-1234-5678"></input>
            </form>
          </div>
          <div className="SignUpNameDiv">
            <span className="SignUpNameLabel">Name</span>
            <form>
              <input className="SignUpNameInput" type="text" placeholder="ex) 홍길동"></input>
            </form>
          </div>
          <div className="SignUpNickNameDiv">
            <span className="SignUpNickLabel">Nick Name</span>
            <form>
              <input className="SignUpNickInput" type="text" placeholder="ex) 김기린"></input>
            </form>
          </div>
          <div className="SignUpPWDiv">
            <div className="SignUpPWView"></div>
            <span className="SignUpPWLabel">Password</span>
            <form>
              <input
                className="SignUpPWInput"
                type="password"
                placeholder="비밀번호를 입력해 주세요 :)"
              ></input>
            </form>
          </div>
          <div className="SignUpPWChkDiv">
            <span className="SignUpPWChkLabel">Password Check</span>
            <div className="SignUpPWHidden"></div>
            <form>
              <input
                className="SignUpPWChkInput"
                type="password"
                placeholder="한번 더 똑같이 적어주세요."
              ></input>
            </form>
          </div>
          <div className="SignUpSeperator1"></div>
          <div className="SignUpAuthDiv">
            <span className="SignUpAuthLabel">핸드폰 인증하기</span>
            <span className="SignUpAuthBtnLabel">인증하기</span>
            <div className="SignUpAuthBtn"></div>
          </div>
          <div className="SignUpAccept1">
            <div className="SignUpAccept1CB"></div>
            <span className="SignUpAccept1Text">전체동의</span>
            <div className="SignUpSeperator2"></div>
          </div>
        </div>
        {/* <div></div> */}
      </div>
    </>
  );
}

export default Main;
