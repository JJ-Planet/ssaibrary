import React from "react";
import Header from "./CommunityDetailHeader";
import Main from "./CommunityDetailMain";
import Footer from "../MainPage/Footer";
import "./CommunityDetailPage.css";

const CommunityDetailPage = () => {
  return (
    <div className="CommunityDetailPage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default CommunityDetailPage;
