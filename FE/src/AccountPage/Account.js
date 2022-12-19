import React from "react";
import Header from "./AccountHeader";
import Body from "./AccountBody";
import Footer from "../MainPage/Footer";
import "./Account.css";
const Account = () => {
  return (
    <div className="Account">
      <Header />
      <Body />
      <Footer />
    </div>
  );
};

export default Account;
