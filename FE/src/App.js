import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LandingPage from "./LandingPage/LandingPage";
import Account from "./AccountPage/AccountPage";
import Reservation from "./ReservationPage/ReservationPage";
import History from "./HistoryPage/HistoryPage";
import Main from "./MainPage/MainPage";
import Community from "./CommunityPage/CommunityPage";
import Login from "./LoginPage/LoginPage";
import SignUp from "./SignUpPage/SignUpPage";
import Modify from "./AccountModifyPage/AccountModifyPage";
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
          <Route path="/history" element={<History />}></Route>
          <Route path="/account/modify" element={<History />}></Route>
          <Route path="/community" element={<Community />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/signUp" element={<SignUp />}></Route>
          <Route path="/modify" element={<Modify />}></Route>

          {/* <Route path="/product/*" element={<Product />}></Route> */}
          {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
