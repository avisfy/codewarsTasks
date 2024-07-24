package org.avisfy.tasks;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseCodeDecoderReal {
    /**
     * Given a string in Morse Code, returns the English translation.
     * Accept dots, dashes and spaces, returns human-readable message.
     */
    public static String decodeMorse(String morseCode) {
        if (morseCode.isEmpty())
            return "";
        return Arrays.stream(morseCode.split("   "))
                .map(w -> Arrays.stream(w.split(" "))
                        .map(l -> MorseCode.get(l))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    /**
     * Given a string of bits, which may or may not begin or end with '0's,
     * and which may have some variation in the length of the time unit used,
     * returns the Morse Code translation of this message.
     * Accepts 0s and 1s, return dots, dashes and spaces
     */
    public static String decodeBitsAdvanced(String bits) {
        //trim 0s
        bits = bits.replaceAll("^0+|0+$", "");
        if (bits.length() == 0)
            return "";

        //split by monotonic sequences 0 or 1 and get array of sequences's lengths
        List<String> segments = Pattern
                .compile("0+|1+")
                .matcher(bits)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());

        //case of only 1s without 0s
        if (segments.size() == 1)
            return ".";

        //Array of lengths of sequences
        List<Integer> segmentLengths = segments
                .stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());

        //split array to 3 clusters
        Map<Integer, List<Integer>> clusters = kMeans(segmentLengths, 3);

        //create pairs of min and max of each cluster
        List<MinMax> minMax = clusters.values().stream().map(v -> {
            int min = v.get(0);
            int max = v.get(v.size() - 1);
            return new MinMax(min, max);
        }).collect(Collectors.toList());

        //replace 0 and 1 sequences
        //by -
        if (minMax.size() > 1) {
            String regexDash = "1{" + minMax.get(1).min + "," + minMax.get(1).max + "}";
            bits = bits.replaceAll(regexDash, "-");
        }
        //by .
        String regexDot = "1{" + minMax.get(0).min + "," + minMax.get(0).max + "}";
        bits = bits.replaceAll(regexDot, ".");
        //by 3 spaces (space between words)
        if (minMax.size() > 2) {
            String regexWordSpace = "0{" + minMax.get(2).min + "," + minMax.get(2).max + "}";
            bits = bits.replaceAll(regexWordSpace, "   ");
        }
        //by one space (between letters)
        if (minMax.size() > 1) {
            String regexLetterSpace = "0{" + minMax.get(1).min + "," + minMax.get(1).max + "}";
            if ((minMax.get(1).max / minMax.get(0).max) >= 6) {
                bits = bits.replaceAll(regexLetterSpace, "   ");
            } else {
                bits = bits.replaceAll(regexLetterSpace, " ");
            }
        }
        //remove shortest 0-sequences
        String regexSymbolSpace = "0{" + minMax.get(0).min + "," + minMax.get(0).max + "}";
        bits = bits.replaceAll(regexSymbolSpace, "");

        return bits;
    }

    /**
     * K means algorithm for splitting array to clusters
     *
     * @param segLengths array of sequences length
     * @param k          cluster number
     * @return pairs of cluster's center and values of this cluster
     */
    public static Map<Integer, List<Integer>> kMeans(List<Integer> segLengths, int k) {
        //calculate initial cluster centers
        List<Integer> centers = new ArrayList<>(k);
        int segMin = segLengths.get(0);
        int segMax = segLengths.get(segLengths.size() - 1);
        int partL = (segMax - segMin) / 3;

        centers.add(segMin + (partL - segMin) / 2);
        centers.add((segMax - segMin) / 2);
        centers.add(segMax);

        int iterCount = 0;
        boolean isDone;
        Map<Integer, List<Integer>> clusterBlocks;
        //calculate clusters and recalculate centers of clusters
        do {
            iterCount++;
            clusterBlocks = getClusterBlocks(segLengths, centers);
            List<Integer> newCenters = new ArrayList<Integer>(k);
            for (int clusterBlock : clusterBlocks.keySet()) {
                List<Integer> segments = clusterBlocks.get(clusterBlock);
                if (segments.size() != 0) {
                    long sum = segments.stream().mapToInt(Integer::intValue).sum();
                    int newCenter = (int) sum / segments.size();
                    newCenters.add(newCenter);
                }
            }
            isDone = centers.equals(newCenters);
            centers = newCenters;
        } while (!isDone && (iterCount < 3));
        return clusterBlocks;
    }


    /**
     * Calculate clusters for one step of k means algorithm
     *
     * @param segLengths array for clustering
     * @param centers    centers of clusters
     * @return pairs of cluster's center and values of this cluster
     */
    private static Map<Integer, List<Integer>> getClusterBlocks(List<Integer> segLengths, List<Integer> centers) {
        var clusters = new LinkedHashMap<Integer, List<Integer>>();
        for (Integer clsEl : centers) {
            clusters.put(clsEl, new ArrayList<>());
        }
        for (Integer segEl : segLengths) {
            int minDel = centers.get(centers.size() - 1) + 1;
            int minCEl = centers.get(0);
            for (Integer cEl : centers) {
                int del = Math.abs(cEl - segEl);
                if (del < minDel) {
                    minDel = del;
                    minCEl = cEl;
                }
            }
            clusters.get(minCEl).add(segEl);
        }
        return clusters;
    }

    private static class MinMax {
        public int min;
        public int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
