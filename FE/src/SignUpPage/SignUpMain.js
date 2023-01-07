import React from "react";
import "./SignUpMain.css";
import { Link } from "react-router-dom";
function Main() {
  return (
    <>
      <div className="SUMain">
        <div className="SUHeader">
          <Link to="/login">
            <span className="SUBackBtn">뒤로</span>
          </Link>
          <span className="SUMainTitle">만나서 반가워요!!😄</span>
          <span className="SUSubTitle">
            예약을 쉽게! 간편하게 ! <br></br>
            안녕하세요 SSaibrary 입니다.
          </span>
        </div>
        <div className="SUInputsDiv">
          <form>
            <div className="SUIDDiv">
              <span className="SUIDLabel">ID</span>
              <input className="SUIDInput" type="text" placeholder="ex) 010-1234-5678"></input>
            </div>
            <div className="SUNameDiv">
              <span className="SUNameLabel">Name</span>
              <input className="SUNameInput" type="text" placeholder="ex) 홍길동"></input>
            </div>
            <div className="SUNickNameDiv">
              <span className="SUNickLabel">Nick Name</span>
              <input className="SUNickInput" type="text" placeholder="ex) 김기린"></input>
            </div>
            <div className="SUPWDiv">
              <div className="SUPWView"></div>
              <span className="SUPWLabel">Password</span>
              <input
                className="SUPWInput"
                type="password"
                placeholder="비밀번호를 입력해 주세요 :)"
              ></input>
            </div>
            <div className="SUPWChkDiv">
              <span className="SUPWChkLabel">Password Check</span>
              <div className="SUPWHidden"></div>
              <input
                className="SUPWChkInput"
                type="password"
                placeholder="한번 더 똑같이 적어주세요."
              ></input>
            </div>
          </form>
          <div className="SUSeperator1"></div>
          <div className="SUAuthDiv">
            <span className="SUAuthLabel">핸드폰 인증하기</span>
            <span className="SUAuthBtnLabel">인증하기</span>
            <div className="SUAuthBtn"></div>
          </div>
          <div className="SUAcceptDiv">
            <div className="SUAcceptCB CB1"></div>
            <span className="SUAcceptText AcceptText1">전체 동의</span>
            <div className="SUSeperator2"></div>
            <div className="SUAcceptCB CB2"></div>
            <div className="SUAcceptText AcceptText2">
              <span className="MandatoryOption">[필수]</span>
              <span>이용약관 동의</span>
              <span className="SULink">보기</span>
            </div>
            <div className="SUAcceptCB CB3"></div>
            <div className="SUAcceptText AcceptText3">
              <span className="MandatoryOption">[필수]</span>
              <span>개인정보 처리방침 동의</span>
              <span className="SULink">보기</span>
            </div>
            <div className="SUAcceptCB CB4"></div>
            <div className="SUAcceptText AcceptText4">
              <span className="MandatoryOption">[필수]</span>
              <span>위치정보 처리방침 동의</span>
              <span className="SULink">보기</span>
            </div>
            <div className="SUAcceptCB CB5"></div>
            <div className="SUAcceptText AcceptText5">
              <span className="OptionalOption">[선택]</span>
              <span>마켓팅 정보 수신 선택 동의</span>
            </div>
            <div className="SUAcceptCB CB6"></div>
            <div className="SUAcceptText AcceptText6">
              <span className="OptionalOption">[선택]</span>
              <span>이메일 수신 동의</span>
            </div>
            <div className="SUAcceptCB CB7"></div>
            <div className="SUAcceptText AcceptText7">
              <span className="OptionalOption">[선택]</span>
              <span>SMS 수신 동의</span>
            </div>
          </div>
          <div className="SUBtnDivs">
            <div className="SUReigsterBtnDiv">
              <span className="SingUpBtnText">회원 가입</span>
              <div className="SingUpBtn"></div>
            </div>
            <div className="SUInitBtnDiv">
              <span className="SUClearBtnDivText">초기화</span>
              <div className="SUClearBtn"></div>
            </div>
          </div>
        </div>
        <div className="SUFooter">
          <span className="SUFooterTitle">
            Copy Right <br></br>
            <a href="https://github.com/JJ-Planet" className="SUFooterA">
              ©JJ Planet All Rights Reserved
            </a>
          </span>
        </div>
      </div>
    </>
  );
}

export default Main;
