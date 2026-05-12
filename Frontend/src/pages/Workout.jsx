import { useState, useEffect } from "react";

export default function Workout({ setPage }) {
    const [exercise, setExercise] = useState("");
    const [reps, setReps] = useState("");
    const [weight, setWeight] = useState("");

    const [list, setList] = useState(() => {
        const saved = localStorage.getItem("workouts");
        return saved ? JSON.parse(saved) : [];
    });

    useEffect(() => {
        localStorage.setItem("workouts", JSON.stringify(list));
    }, [list]);

    function addSet() {
        const newEntry = {
            exercise,
            reps,
            weight
        };

        setList([...list, newEntry]);

        setExercise("");
        setReps("");
        setWeight("");
    }

    return (
        <div>
            <h2>Workout Session</h2>

            <input
                placeholder="Exercise"
                value={exercise}
                onChange={(e) => setExercise(e.target.value)}
            />

            <input
                placeholder="Reps"
                value={reps}
                onChange={(e) => setReps(e.target.value)}
            />

            <input
                placeholder="Weight"
                value={weight}
                onChange={(e) => setWeight(e.target.value)}
            />

            <button onClick={addSet}>Add Set</button>

            <h3>Current Workout</h3>

            {list.map((item, i) => (
                <p key={i}>
                    {item.exercise} — {item.reps} reps @ {item.weight}kg
                </p>
            ))}

            <button onClick={() => setPage("home")}>
                Finish Workout
            </button>
        </div>
    );
}