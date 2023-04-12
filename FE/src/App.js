import React, { useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import "./App.css";
import Transition from "./Transition";

const App = () => {
  // useEffect(() => {
  //   // 카카오 SDK 초기화
  //   if (!window.Kakao.isInitialized()) {
  //     // 초기화 되어있지 않을 경우(중복 초기화 에러 방지)
  //     window.Kakao.init(process.env.PUBLIC_KAKAO_SDK_KEY); // env 환경변수 사용
  //     // console.log(window.Kakao.isInitialized()); // 초기화 여부 확인(true 나와야 함)
  //   }
  // }, []);

  return (
    <div className="App">
      <Router>
        <Transition />
      </Router>
    </div>
  );
};

export default App;
