import React from "react";
import Header from "./LoginHeader";
import Main from "./LoginMain";
import Footer from "../LandingPage/CopyRightFooter";
// import Footer from "./LoginFooter";
import "./LoginPage.css";
const LoginPage = () => {
  return (
    <div className="Login">
      <Header />
      <Main />
      <Footer />
    </div>
  );
};

export default LoginPage;
