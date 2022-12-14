import React from "react";
import Header from "./CommunityWriteHeader";
import Main from "./CommunityWriteMain";
import Footer from "../MainPage/Footer";
import "./CommunityWritePage.css";
const CommunityWritePage = () => {
  return (
    <div className="CommunityWritePage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default CommunityWritePage;
