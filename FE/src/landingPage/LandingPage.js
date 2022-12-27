import "./LandingPage.css";
import { Link } from "react-router-dom";
import Footer from "./CopyRightFooter";
function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <div className="App-logo">
          <Link to="/login">
            <span className="App-text">SSAIBRARY</span>
          </Link>
        </div>
      </header>

      <Footer></Footer>
    </div>
  );
}

export default LandingPage;
