import React from "react";
import Header from "./NoticeHeader";
import Main from "./NoticeMain";
import Footer from "../MainPage/Footer";
import "./NoticePage.css";
const NoticePage = () => {
  return (
    <div className="Notice">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default NoticePage;
