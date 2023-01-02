import React from "react";
import { BrowserRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import "./App.css";
import Transition from "./Transition";

const App = () => {
  return (
    <div className="App">
      <Router>
        <Transition />
      </Router>
    </div>
  );
};

export default App;
