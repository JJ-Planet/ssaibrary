import "./App.css";
import { Link } from "react-router-dom";

function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <div className="App-logo">
          <Link to="/Main">
            <span className="App-text">SSAIBRARY</span>
          </Link>
        </div>
      </header>
      <div className="App-footer">
        <div className="App-footer-text">Copy Right ©JJ Planet All Rights Reserved</div>
      </div>
    </div>
  );
}

export default LandingPage;
