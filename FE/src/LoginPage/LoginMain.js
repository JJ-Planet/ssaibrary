import React, { useState } from "react";
import { Link } from "react-router-dom";

import "./LoginMain.css";

function Main() {
  // 로그인 상태유지(체크박스) true 일 때, 이벤트 발생하기 위한 코드
  const [CBClick, setCBClick] = useState(false);
  if (CBClick) {
    console.log("로그인 상태유지 OK");
  }
  return (
    <>
      <div className="LoginMain">
        <span className="MainTitle">
          안녕하세요✋ <br></br>예약을 빠르게 돕는<br></br> SSaibrary 입니다:)
        </span>
        <form>
          <div className="IdDiv">
            <span className="IDLabel">ID</span>
            <input type="text" className="IDInput"></input>
          </div>
          <div className="PwDiv">
            <span className="PWLabel">Password</span>
            <input type="password" className="PWInput"></input>
          </div>
          <div className="SubDiv">
            <input
              type="checkbox"
              className="KeepLoginCB"
              onClick={() => {
                setCBClick((e) => !e);
              }}
            ></input>
            <span className="KeepLoginCBLabel">로그인 상태 유지</span>
            <span className="searchPWBtn">비밀번호 찾기</span>
          </div>
        </form>
        <Link to="/main">
          <div className="LoginBtnDiv">
            <span className="LoginBtnTitle">로그인</span>
            <div className="LoginBtn"></div>
          </div>
        </Link>
        <div className="SingUpDiv">
          <span className="SignUpTitle">회원가입을 하지 않았다면? </span>
          <Link to="/signUp">
            <span className="SignUpBtn">회원가입</span>
          </Link>
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
