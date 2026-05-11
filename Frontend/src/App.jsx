import { useState } from "react";
import Home from "./pages/Home";
import Workout from "./pages/Workout";

function App() {
  const [page, setPage] = useState("home");

  return (
      <div style={{ padding: 20 }}>
        {page === "home" && <Home setPage={setPage} />}
        {page === "workout" && <Workout setPage={setPage} />}
      </div>
  );
}

export default App;