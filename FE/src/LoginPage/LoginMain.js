// import React, { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./LoginMain.css";

// const LoginMainPage = document.querySelector('.LoginMain');

function Main() {
  return (
    <>
      <div className="LoginMain">
        <span className="MainTitle">
          안녕하세요✋ <br></br>예약을 빠르게 돕는<br></br> SSaibrary 입니다:)
        </span>
        <div className="IdDiv">
          <span className="IDLabel">ID</span>
          <form>
            <input type="text" placeholder="ID" className="IDInput"></input>
          </form>
        </div>
        <div className="PwDiv">
          <span className="PWLabel">Password</span>
          <form>
            <input type="password" placeholder="Password" className="PWInput"></input>
          </form>
        </div>
        <div className="SubDiv">
          <div className="KeepLoginCB"></div>
          <span className="KeepLoginCBLabel">로그인 상태 유지</span>
          <span className="searchPWBtn">아이디 / 비밀번호 찾기</span>
        </div>
        <div className="LoginBtnDiv">
          <Link to="/main">
            <span className="LoginBtnTitle">로그인</span>
          </Link>
          <div className="LoginBtn"></div>
        </div>
        <div className="SingUpDiv">
          <span className="SignUpTitle">회원가입을 하지 않았다면?</span>
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
