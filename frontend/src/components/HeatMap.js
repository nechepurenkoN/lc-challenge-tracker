const DAYS = ["MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"]

function groupTasksByDay(solvedTasks) {
    return Object.fromEntries(DAYS.map(day => [day, solvedTasks.filter(task => task.day === day)]));
}

export default function HeatMap({solvedTasks}) {

    const groupedByDay = groupTasksByDay(solvedTasks);

    return (
        <div className={"heatmap"}>
            {DAYS.map(day => (
                <svg width={"10px"} height={"10px"}>
                    <rect width={"10px"} height={"10px"} rx={2} ry={2}
                          className={`heatmap-day-rect heatmap-day-rect-${Math.min(groupedByDay[day].length, 4)}`} key={day}/>
                </svg>
            ))}
        </div>
    );
}