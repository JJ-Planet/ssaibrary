import React from "react";
import "./LoginMain.css";
function Main() {
  return (
    <>
      <div className="LoginMain">
        <span className="MainTitle">안녕하세요✋ 예약을 빠르게 돕는 SSaibrary 입니다:)</span>
        <div className="IdDiv">
          <span className="IDLabel">ID</span>
          <form>
            <input type="text" placeholder="ID" className="IDInput"></input>
          </form>
        </div>
        <div className="PwDiv">
          <span className="PWLabel">Password</span>
          <form>
            <input type="text" placeholder="Password" className="PWInput"></input>
          </form>
        </div>
        <div className="SubDiv">
          <div className="KeepLoginCB"></div>
          <span className="KeepLoginCBLabel">로그인 상태 유지</span>
          <span className="searchPWBtn">아이디 / 비밀번호 찾기</span>
        </div>
        <div className="LoginBtnDiv">
          <span className="LoginBtnTitle">로그인</span>
          <div className="LoginBtn"></div>
        </div>
        <div className="SingUpDiv">
          <span className="SignUpTitle">회원가입을 하지 않았다면 ?</span>
          <span className="SignUpBtn">회원가입</span>
        </div>
        <div className="SNSFrame">
          <div className="SNSTitle"></div>
          <div className="naver"></div>
          <div className="facebook"></div>
          <div className="kakao1"></div>
          <div className="google"></div>
          <div className="googleDiv"></div>
        </div>
      </div>
    </>
  );
}

export default Main;
