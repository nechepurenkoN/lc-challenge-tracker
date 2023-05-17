export default function Loader({ isLoading }) {
    return (
        <div className={"loader-wrapper"}>
            {isLoading ? (
                <div className="spinner-border spinner-border-sm text-primary" role="status"></div>
            ) : ""}
        </div>
    );
}