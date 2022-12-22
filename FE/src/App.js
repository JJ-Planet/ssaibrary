import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LandingPage from "./landingPage/Landing";
import Account from "./AccountPage/Account";
import Reservation from "./ReservationPage/Reservation";
import Main from "./MainPage/Main";
import "./App.css";

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LandingPage />}></Route>
          <Route path="/main" element={<Main />}></Route>
          <Route path="/account" element={<Account />}></Route>
          <Route path="/reservation" element={<Reservation />}></Route>
          {/* <Route path="/product/*" element={<Product />}></Route> */}
          {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
