import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "../pages/HomePage";

function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        {/* 기본 경로 → HomePage */}
        <Route path="/" element={<HomePage />} />        
        {/* 그 외 경로는 나중에 필요에 따라 추가 */}
      </Routes>
    </BrowserRouter>
  );
}

export default AppRouter;