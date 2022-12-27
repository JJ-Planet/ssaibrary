import React from "react";
import "./SignUpMain.css";
// import { Link } from "react-router-dom";
function Main() {
  return (
    <>
      <div className="SignUpMain">
        <div className="SignUpInputsDiv1234567">
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
          <div className="SignUpAcceptDiv">
            <div className="SignUpAcceptCB CB1"></div>
            <span className="SignUpAcceptText AcceptText1">전체 동의</span>
            <div className="SignUpSeperator2"></div>
            <div className="SignUpAcceptCB CB2"></div>
            <div className="SignUpAcceptText AcceptText2">
              <span className="MandatoryOption">[필수]</span>
              <span>이용약관 동의</span>
              <span className="SignUpLink">보기</span>
            </div>
            <div className="SignUpAcceptCB CB3"></div>
            <div className="SignUpAcceptText AcceptText3">
              <span className="MandatoryOption">[필수]</span>
              <span>개인정보 처리방침 동의</span>
              <span className="SignUpLink">보기</span>
            </div>
            <div className="SignUpAcceptCB CB4"></div>
            <div className="SignUpAcceptText AcceptText4">
              <span className="MandatoryOption">[필수]</span>
              <span>위치정보 처리방침 동의</span>
              <span className="SignUpLink">보기</span>
            </div>
            <div className="SignUpAcceptCB CB5"></div>
            <div className="SignUpAcceptText AcceptText5">
              <span className="OptionalOption">[선택]</span>
              <span>마켓팅 정보 수신 선택 동의</span>
            </div>
            <div className="SignUpAcceptCB CB6"></div>
            <div className="SignUpAcceptText AcceptText6">
              <span className="OptionalOption">[선택]</span>
              <span>이메일 수신 동의</span>
            </div>
            <div className="SignUpAcceptCB CB7"></div>
            <div className="SignUpAcceptText AcceptText7">
              <span className="OptionalOption">[선택]</span>
              <span>SMS 수신 동의</span>
            </div>
          </div>
          <div className="SignUpBtnDivs">
            <div className="SignUpReigsterBtnDiv">
              <span className="SingUpBtnText">회원 가입</span>
              <div className="SingUpBtn"></div>
            </div>
            <div className="SignUpInitBtnDiv">
              <span className="SignUpClearBtnDivText">초기화</span>
              <div className="SignUpClearBtn"></div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
