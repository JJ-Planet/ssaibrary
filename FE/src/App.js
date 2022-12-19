import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Account from "./AccountPage/Account";

import LandingPage from "./MainPage/LandingPage";
import Main from "./MainPage/Main";

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LandingPage />}></Route>
          <Route path="/main" element={<Main />}></Route>
          <Route path="/account" element={<Account />}></Route>
          {/* <Route path="/product/*" element={<Product />}></Route> */}
          {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
