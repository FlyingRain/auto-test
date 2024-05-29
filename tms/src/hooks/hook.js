
export default function common() {
    const fuzzyQuery = (data, results) => {
        return results.filter(result => {
            result.toLowerCase().includes(data.toLowerCase())
        })
    }
    return {fuzzyQuery}
}