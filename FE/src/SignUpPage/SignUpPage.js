import React from "react";
import Header from "./SignUpHeader";
import Main from "./SignUpMain";
import Footer from "../LandingPage/CopyRightFooter";
import "./SignUpPage.css";
const SignUpPage = () => {
  return (
    <div className="SignUpPage">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default SignUpPage;
