import "./LandingPage.css";
import { useNavigate } from "react-router-dom";
import Footer from "./CopyRightFooter";
import React, { useEffect } from "react";

function LandingPage() {
  // push 사용 위해 usehistory 불러오기
  const navigate = useNavigate();
  // 2초 뒤 채팅 메인으로 넘어가는 함수 작성
  const timeout = () => {
    setTimeout(() => {
      navigate("/login");
    }, 2000);
  };

  // 컴포넌트가 화면에 다 나타나면 timeout 함수 실행
  useEffect(() => {
    timeout();
    return () => {
      // clear 해줌
      clearTimeout(timeout);
    };
  });
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <div className="App-logo">
          <span className="App-text">SSAIBRARY</span>
        </div>
      </header>

      <Footer></Footer>
    </div>
  );
}

export default LandingPage;
