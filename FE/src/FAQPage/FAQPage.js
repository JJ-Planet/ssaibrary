import React from "react";
import Header from "./FAQHeader";
import Main from "./FAQMain";
import Footer from "../MainPage/Footer";
import "./FAQPage.css";

const FAQPage = () => {
  return (
    <div className="FAQPage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default FAQPage;
