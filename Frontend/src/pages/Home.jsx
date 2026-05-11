export default function Home({ setPage }) {
    return (
        <div>
            <h1>Fitness Tracker</h1>

            <button onClick={() => setPage("workout")}>
                Start Workout
            </button>
        </div>
    );
}