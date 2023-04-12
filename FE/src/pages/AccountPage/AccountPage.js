import React from "react";
import Header from "./AccountHeader";
import Main from "./AccountMain";
import Footer from "../MainPage/Footer";
import "./AccountPage.css";
const AccountPage = () => {
  return (
    <div className="Account">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default AccountPage;
